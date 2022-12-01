#include <stdio.h>
#include <string.h>


void reverse(char s[]){
    int c, j, i;

    for(i = 0, j = strlen(s) - 1; i < j; i++, j--){
        c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}

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

long a16toi2(char s[])
{
     // Set to upper case
    for (int u = 0; s[u] != '\0'; u++)
    {
        if ((s[u] >= 'a' && s[u] <= 'f'))
        {
            s[u] = (s[u] - 32);
        }
    }
    
   long n = 0;
        for(int i = 2; s[i] != '\0'; i++){

            if (s[i] >= '0' && s[i] <= '9')
                n = n * 16 + (s[i] - 48);

            else if(s[i] >='A' && s[i] <= 'F')
                n = n * 16 + (s[i] - 55);
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

Take highest power of 16 divide by it then make sure its an integer and then multiply our number by 16 
then subtract that number from the heighest power of 16
*/
int a16toi(char s[])
{
    int length = strlen(s);
    int powerOf = length;

    for (int u = 0; s[u] != '\0'; u++)
    {
        if ((s[u] >= 'a' && s[u] <= 'f'))
        {
            s[u] = (s[u] - 32);
        }
    }

    int n = 0;
    for (int i = 2; s[i] != '\0'; i++)
    {

        int pow = 1;
        printf("powerOf = %d\n", powerOf);
        if (powerOf != 2)
        {
            for (int j = powerOf; j > 3; j--)
            {
                pow = pow * 16;
            }
        }
        else
            pow = 1;
        powerOf--;

        if (s[i] >= '0' && s[i] <= '9')
        {
            // printf("n = %d s[i] = %d\n", n, s[i]-48);
            n += (s[i] - 48) * pow;
            printf(" pow = %d\n", pow);
            // printf("n now = %d\n", n);
        }
        else if ((s[i] >= 'A' && s[i] <= 'F'))
        {
            // printf("n = %d s[i] = %d\n", n, s[i]);
            n += (s[i] - 55) * pow;
            printf(" pow = %d\n", pow);
            // printf("n now letter= %d and letter is %d\n", n, (s[i]-55));
        }
        else
        { // error
            printf("Not right %d\n", s[i]);
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
    while(integer != 0){
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
    //consider reverse entry
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
    while(integer != 0){
        if(integer % 8 > 0){
            octal[i] = (integer % 8) + '0';
            integer = integer / 8;
            i++;
        }
        e   
             octal[i] = '0';
            integer = integer / 8;
            i++;
        }
    }
    octal[i] = '\0';

    for(int j = 0; octal[j] != '\0'; j++){
        printf("here %c \n", octal[j] );
    }
    reverse(octal);
}

/*
This function should convert the int value in integer
to its equivalent hexadecimal representation, storing that
value into the character array named hex.  Be sure
to add a null terminator to hex.
*/
void toHex(long integer, char hex[])
{

int i  = 0;
while(integer != 0){

    //if there is a remainder and it is a letter
    if(integer % 16 > 0 && ((integer % 16) >= 10)){
        int remainder = integer % 16;
        if((remainder - 10) == 0){
           hex[i] = 'A'; 
        }
        else if((remainder - 10) == 1){
           hex[i] = 'B'; 
        }
        else if((remainder - 10) == 2){
           hex[i] = 'C'; 
        }
        else if((remainder - 10) == 3){
           hex[i] = 'D'; 
        }
        else if((remainder - 10) == 4){
           hex[i] = 'E'; 
        }
        else if((remainder - 10) == 5){
           hex[i] = 'F'; 
        }
        printf("Added letter\n");
        integer = integer / 16;
        i++;
    }
    //if there is a remainder and it is a digit
    else if(integer % 16 > 0 && ((integer % 16) < 10)){
        hex[i] = (integer % 16) + '0';
        printf("Added number\n");
        integer = integer / 16;
        i++;
    }
    //Number no Remainder
    else if((integer % 16) == 0  && (integer % 16) < 10){
        hex[i] = (integer % 16) + '0';
        printf("Added letter no remainder\n");
        integer = integer / 16;
        i++;
    }
    else{
            hex[i] = '0';
            printf("Added 0\n");
            integer = integer / 8;
            i++;
        } 
}
hex[i] = '\0';
reverse(hex);
    
}


int main(int argc, char const *argv[])
{
    char converted[15];

    // char bin[] = "0b10001";
    // int dec = a2toi(bin);
    // printf("Bin 10001 to dec = %d\n", dec);

    // char bin2[] = "017";
    // dec = a8toi(bin2);
    // printf("Octal 17 to dec = %d\n", dec);

    long dec = 0;

    // char hex[] = "0x7C9F";
    // dec = a16toi(hex);
    // printf("Hex 0x7C9F to dec = %ld\n", dec);

    char hex2[] = "0x56fffffff";
    dec = a16toi2(hex2);
    printf("Hex2 0x7C9F to dec = %ld\n", dec);



    // int toBinaryT = 14;
    // toBinary(toBinaryT, converted);
    // printf("Converted %d to binary: ", toBinaryT);
    // for(int i = 0; converted[i] != '\0'; i++){
    //     printf("%c ", converted[i]);
    // }
    // printf("\n");

    // int tooT = 101;
    // toOctal(tooT, converted);
    // printf("Converted %d to octal: ", tooT);
    // for(int i = 0; converted[i] != '\0'; i++){
    //     printf("%c ", converted[i]);
    // }
    // printf("\n");

    // int tohexT = 921;
    // toHex(tohexT, converted);
    // printf("Converted %d to hex: ", tohexT);
    // for(int i = 0; converted[i] != '\0'; i++){
    //     printf("%c", converted[i]);
    // }
    // printf("\n");
}
