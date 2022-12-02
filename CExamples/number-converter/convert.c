#include <stdio.h>
#include <string.h>

// reverse string
void reverse(char s[])
{
    int c, j, i;

    for (i = 0, j = strlen(s) - 1; i < j; i++, j--)
    {
        c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}

/*
This is the atoi function we went over in class.
You can use it to convert an array of characters to
a decimal value.
You should modify it to return -1 if s contains a
character other than the digits 0 through 9 and
the null terminator
 */
int a10toi(char s[])
{
    int i, n;

    n = 0;
    for (i = 0; s[i] != '\0'; i++)
    {
        if (s[i] >= '0' && s[i] <= '9')
        {
            n = 10 * n + (s[i] - '0');
        }
        else
            return -1;
    }
    return n;
}

/*
This function should convert the value in the character
array s, which is assumed to be a binary value, to a
decimal equivalent.
It should return -1 if s contains any character other than 0 or 1,
after the initial 0b
*/
int a2toi(char s[])
{

    // i = 2 ignores first two values
    int n = 0;
    for (int i = 2; s[i] != '\0'; i++)
    {
        if (s[i] == '1' || s[i] == '0')
        {
            n = n * 2 + (s[i] - 48);
        }
        else
            return -1;
    }
    return n;
}

/*
This function should convert the value in the character
array s, which is assumed to be an octal value, to a
decimal equivalent
It should return -1 if s contains any character not in the range
'0' to '7'
*/
int a8toi(char s[])
{
    int n = 0;
    for (int i = 1; s[i] != '\0'; i++)
    {
        if (s[i] >= '0' && s[i] <= '7')
        {
            n = n * 8 + (s[i] - 48);
        }
        else
            return -1;
    }
    return n;
}

/*
This function should convert the value in the character
array s, which is assumed to be an hexadecimal value, to a
decimal equivalent
It should return -1 if s contains any character that isn't
either between '0' and '9' or 'A' and 'F' after the initial
0x.
*/
int a16toi(char s[])
{
    int length = strlen(s);
    int powerOf = length;

    // Set to upper case
    for (int u = 0; s[u] != '\0'; u++)
    {
        if ((s[u] >= 'a' && s[u] <= 'f'))
        {
            s[u] = (s[u] - 32);
        }
    }
    // Start with first value of hexadecimal and move up to the end
    // Find power i should be working backwards
    int n = 0;
    for (int i = 2; s[i] != '\0'; i++)
    {

        int pow = 1;
        // Not equal to 2 since those are the first values of the array
        if (powerOf != 2)
        {
            // Greather than three since the first value changes pow from one to 16
            for (int j = powerOf; j > 3; j--)
            {
                pow = pow * 16;
            }
        }
        else
            pow = 1;
        powerOf--;

        // compute
        if (s[i] >= '0' && s[i] <= '9')
        {
            n += (s[i] - 48) * pow;
        }
        else if ((s[i] >= 'A' && s[i] <= 'F'))
        {
            n += (s[i] - 55) * pow;
        }
        else
        { // error
            return -1;
        }
    }
    return n;
}

/*
This function should convert the int value in integer
to its equivalent binary representation, storing that
value into the character array named binary.  Be sure
to add a null terminator to binary.
*/
void toBinary(int integer, char binary[])
{
    int i = 0;
    while (integer != 0)
    {
        if (integer % 2 == 1)
        {
            binary[i] = 49;
            integer = integer / 2;
            i++;
        }
        else
        {
            binary[i] = 48;
            integer = integer / 2;
            i++;
        }
    }
    binary[i] = '\0';
    reverse(binary);
    // consider reverse entry
}

/*
This function should convert the int value in integer
to its equivalent octal representation, storing that
value into the character array named octal.  Be sure
to add a null terminator to octal.
*/
void toOctal(int integer, char octal[])
{
    int i = 0;
    while (integer != 0)
    {
        if (integer % 8 > 0)
        {
            octal[i] = (integer % 8) + '0';
            integer = integer / 8;
            i++;
        }
        else
        {
            octal[i] = '0';
            integer = integer / 8;
            i++;
        }
    }
    octal[i] = '\0';
    reverse(octal);
}

/*
This function should convert the int value in integer
to its equivalent decimal representation, storing that
value into the character array named decimal.  Be sure
to add a null terminator to decimal.
*/
void toDecimal(int integer, char decimal[])
{
    int i, sign;

    if ((sign = integer) < 0)
        integer = -integer;
    i = 0;
    do
    {
        decimal[i++] = integer % 10 + '0';
    } while ((integer /= 10) > 0);
    if (sign < 0)
        decimal[i++] = '-';
    decimal[i] = '\0';
    reverse(decimal);
}

/*
This function should convert the int value in integer
to its equivalent hexadecimal representation, storing that
value into the character array named hex.  Be sure
to add a null terminator to hex.
*/
void toHex(int integer, char hex[])
{

    int i = 0;
    while (integer != 0)
    {

        // if there is a remainder and it is a letter
        if (integer % 16 > 0 && ((integer % 16) >= 10))
        {
            int remainder = integer % 16;
            if ((remainder - 10) == 0)
            {
                hex[i] = 'A';
            }
            else if ((remainder - 10) == 1)
            {
                hex[i] = 'B';
            }
            else if ((remainder - 10) == 2)
            {
                hex[i] = 'C';
            }
            else if ((remainder - 10) == 3)
            {
                hex[i] = 'D';
            }
            else if ((remainder - 10) == 4)
            {
                hex[i] = 'E';
            }
            else if ((remainder - 10) == 5)
            {
                hex[i] = 'F';
            }
            integer = integer / 16;
            i++;
        }
        // if there is a remainder and it is a digit
        else if (integer % 16 > 0 && ((integer % 16) < 10))
        {
            hex[i] = (integer % 16) + '0';
            integer = integer / 16;
            i++;
        }
        // Number no Remainder
        else if ((integer % 16) == 0 && (integer % 16) < 10)
        {
            hex[i] = (integer % 16) + '0';
            integer = integer / 16;
            i++;
        }
        else
        {
            hex[i] = '0';
            integer = integer / 8;
            i++;
        }
    }
    hex[i] = '\0';
    reverse(hex);
}

#define DECIMAL 0
#define BINARY 1
#define OCTAL 2
#define HEX 3
#define ERROR 4

int main(int argc, char *argv[])
{
    //  Declare a character array named converted that is large enough to hold
    //  the largest possible output value, along with a null
    //  terminator
    char converted[11];
    converted[11] = '\0';

    //  Validate there are at least 2 command line arguments
    //  If not, print an error message and return 1
    if (!(argc >= 2))
    {
        printf("At least 2 command line arguments must be supplied \nUsage: convert.exe binary|octal|decimal|hex num1 [num2 num3 ... numn]\n");
        return 1;
    }

    //  Validate the first command line argument has a
    //  value representing a valid output format.
    //  If not, print an error message and return 2
    char *argValue = argv[1];
    int state = -1;

    if ((strcmp(argValue, "decimal") == 0))
    {
        state = DECIMAL;
    }
    else if ((strcmp(argValue, "octal") == 0))
    {
        state = OCTAL;
    }
    else if ((strcmp(argValue, "hex") == 0))
    {
        state = HEX;
    }
    else if ((strcmp(argValue, "binary") == 0))
    {
        state = BINARY;
    }
    else
    {
        printf("Invalid conversion to %s\nUsage: convert.exe binary|octal|decimal|hex num1 [num2 num3 ... numn]\n", argValue);
        return 2;
    }

    //  For each command line argument after the first one
    //  Determine the type of value based on the first 1 or 2 characters
    for (int i = 2; i <= argc - 1; i++)
    {
        char *type = argv[i];
        int length = strlen(type);

        // get second character
        int conversion = type[1];

        //  Convert the number into its decimal representation
        int dec = 0;
        char *prePrintState = "";
        int found = 0;
        if (type[0] >= '1' && type[0] <= '9')
        {
            dec = a10toi(type);
            prePrintState = "decimal";
        }
        else if (conversion == 'b')
        {
            dec = a2toi(type);
            prePrintState = "binary";
        }
        else if (conversion >= '0' && conversion <= '7')
        {
            dec = a8toi(type);
            prePrintState = "octal";
        }
        else if (conversion == 'x')
        {
            dec = a16toi(type);
            prePrintState = "hex";
        }
        else
        { // error
            prePrintState = "Invalid base number";
            found = 1;
        }

        //  Call the appropriate toXX function to convert the number to the
        //  desired output format, storing the result in the
        //  array named converted
        char *postPrintState = "";
        if (state == DECIMAL)
        {
            // printf("Convert to DECIMAL\n");
            toDecimal(dec, converted);
            postPrintState = "decimal";
        }
        else if (state == BINARY)
        {
            // printf("Convert to BINARY\n");
            toBinary(dec, converted);
            postPrintState = "binary";
        }
        else if (state == OCTAL)
        {
            // printf("Convert to OCTAL\n");
            toOctal(dec, converted);
            postPrintState = "octal";
        }
        else if (state == HEX)
        {
            // printf("Convert to HEX\n");
            toHex(dec, converted);
            postPrintState = "hex";
        }
        else
        { // error
            postPrintState = "Invalid number base";
        }
        //  Output the result of the conversion.

        if (found == 1)
        {
            printf("%s -> %s\n", type, prePrintState);
        }
        else if (dec == -1)
        {
            printf("%s (%s)-> Invalid number\n", type, prePrintState);
        }
        else
        { // Correct Usage
            printf("%s (%s) -> ", type, prePrintState);
            for (int i = 0; converted[i] != '\0'; i++)
            {
                printf("%c", converted[i]);
            }
            printf(" (%s)\n", postPrintState);
        }
    }
    return 0;
}
