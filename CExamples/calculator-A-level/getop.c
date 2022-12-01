#include <stdio.h>
#include <ctype.h>
#include <math.h>
#include "calc.h"

#define TRIG '1'
#define MEMORY '2'
#define ACCESSMEM '3'

int getop(char s[])
{
   int i, c;

   while ((s[0] = c = getch()) == ' ' || c == '\t')
       ;
   s[1] = '\0';
   
   i = 0;
    //reading things ot be stored in M Array
    if(c == '>'){
        while((s[++i] = (c = getch())) != '\n' && c != ' ')
           ;
        ungetch(c);
        s[i] = '\0';
        return MEMORY;
    }

   //reading in string for trig functions and constants
   if(isalpha(c)){
        //Want to access memory 
        if(c == 'M'){
            while((s[++i] = (c = getch())) != '\n' && c != ' ')
           ;
        ungetch(c);
        s[i] = '\0';
        return ACCESSMEM;
        }

        while(isalpha(s[++i] = c = getch()))
            ;
        ungetch(c);
        s[i] = '\0';
        return TRIG;
    }

   if(!isdigit(c) && c !='.' && c != '*' && c != '\"')
       return c;

    if (isdigit(c))
       while(isdigit(s[++i] = c = getch()))
           ;
   if(c=='.')
       while (isdigit(s[++i] = c = getch()))
           ;
    //Using ** as pow
    if(c == '*'){
        int count = 1;
        while((c = getch()) == '*')
            count++;
        ungetch(c);
        if(count == 2)
            return '^';
        else if(count == 1)
            return '*';
        else
            return 0;
    }

   s[i] = '\0';
   if(c != EOF)
       ungetch(c);
   return NUMBER;
}
