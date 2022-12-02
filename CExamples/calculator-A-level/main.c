#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
#include "calc.h"

#define MAXOP 100
#define TRIG '1'
#define MEMORY '2'
#define ACCESSMEM '3'

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
/** Check if condtions are met which include 
 * First character being an uppercase M, second character
 * being a slot from 0 - 9 third being an end of array. 
 * Push the values from the slot. 
*/
int access(char s[], double m[]){
    int slot;
    if((s[0] == 'M') && ((s[1] >= '0') && s[1] <= '9') && s[2] == '\0'){
        slot = s[1] - 48;
        push(m[slot]);
    }
    else
        return 0;
    return 1;
}

/** Check if save conditions are met which include
 * First character being > second being a number slot from 0 - 9
 * third character being end of array.
 * Then set slot number equal to the second character, pop the value
 * to save to the array. Save it to the array of memory passed and then 
 * push the save value back onto the stack. 
*/
int save(char s[], double m[]){
     int slot;
     double toSave;
   if((s[0] == '>') && ((s[1] >= '0') && s[1] <= '9') && s[2] == '\0'){

    slot = s[1] - 48;
    toSave = pop();

    m[slot] = toSave;
    
    push(toSave);
   } 
   else 
      return 0;
return 1;
}

int trig(char s[]){
    int op2 = 0;

    if(!strcmp(s, "e"))
        push(M_E);
    else if(!strcmp(s, "pi"))
        push(M_PI);
    else if(!strcmp(s, "sine")){
        push(sin(pop()*(M_PI/180)));
    }
    else if(!strcmp(s, "cosine")){
        push(cos(pop()*(M_PI/180)));
    }
    else if(!strcmp(s, "tangent")){
        push(tan(pop()*(M_PI/180)));
    }
    else
        return 0;
    return 1;
}


int main(int argc, char* argv[])
{
    int type;
    double op2;
    char s[MAXOP];
    double m[11];
    m[11] = '\0';

    for(int k = 0; k < 11; k++)
        m[k] = 0;

    /**If argc is greater than 0 read in the argument.
     * This argument (since in *argv) will be an array
     * of pointers. Therefore, use outer loop for all 
     * arrays of pointers in argv, and an inner loop to 
     * go through each array. First dereference and 
     * then ungetch since getch will read from the array
     * ungetch loads it into. I don't know why I have 
     * to reverse the array other than it works this way.
    */
   if(argc > 1){
    int i = 0;
    for(int i = 1; i < argc; i++){
        reverse(argv[i]);
        char* evalute = argv[i];
        
        ungetch('\n');
        while(*evalute){
            ungetch(*evalute);
            evalute++;
        } 
    }
   }


    while ((type = getop(s)) != EOF)
    {
    
        switch (type)
        {
        case NUMBER:
            push(atof(s));
            break;
        //e or pi
        case TRIG:
            if(!trig(s)){
                printf("Unrecognized function %s entered\n", s);
                while ((type = getch()) != '\n')
                    ;  
                clean();
            }
            break;
        case MEMORY:
            if(!save(s,m)){
                printf("Invalid memory location\n");
                while ((type = getch()) != '\n')
                    ;  
                clean();
            }
            break;
        case ACCESSMEM:
            if(!access(s, m)){
                printf("Failed to access memory. Slot %s entered\n", s);
                printf("Terminating the rest of the expression...\n");
                while ((type = getch()) != '\n')
                    ;  
                clean();
            }
            break;
        case '+':
            push(pop() + pop());
            break;
        case '-':
            op2 = pop();
            push(pop() - op2);
            break;
        //mod operator    
        case '%':
            if((op2 = pop()) == 0){
                printf("Illegal attempt to divide by zero\n");
                while ((type = getch()) != '\n')
                    ;   
                clean();
                break;
            } 
            else
                push(((int) pop()) % ((int) op2));
            break;
        //Multiplication
        case '*':
            push(pop() * pop());
            break;
        //Division
        case '/':
            if((op2 = pop()) == 0){
                printf("Illegal attempt to divide by zero\n");
                while ((type = getch()) != '\n')
                    ;   
                clean();
                break;
            }              
            else{
                push(pop() / op2);
            }
            break;
        //power of
        case '^':
            op2 = pop();
            push(pow(pop(), op2));
            break;
        case '\n':
            printf("\t%.8g\n", pop());
            break;
        default:
            printf("error: unknown command %s\n", s);
            break;   
    }   
}
return 0;
}
