#include "LinkedList.h"
#include <stdio.h>

void printSeparator () {
	int i = 0;
	for (i = 0; i < 80; i++) {
		printf ("=");
	}	
	printf ("\n");
}

int main (int argc, char** argv) {
  struct LinkedList* list = create("Hello");
  insertAfter(list, "Hello", " ");
  insertAfter(list, " ", "world");
  insertAfter(list, "world", "\n");
  
  //printing list
  printf("Printing List:\n");
  printf ("List allocated at %p\n\n", list->head);
  print(list);
  printSeparator();

  //test search
  printf("Testing search:\n");
  printf("Search for Hello: %d %s\n", contains(list, "Hello"), (contains(list, "Hello") ?  "Found!" : "Not found"));
  printf("Search for \" \": %d %s\n", contains(list, " "), (contains(list, " ") ?  "Found!" : "Not found"));
  printf("Search for world: %d %s\n", contains(list, "world"), (contains(list, "world") ?  "Found!" : "Not found"));
  //Not Found Test
  printf("Should not find Goodbye: %d %s\n", contains(list, "Goodbye"), (contains(list, "not found") ?  "Found!" : "Not found!"));
  printSeparator();

  //testing copy
  struct LinkedList* listCopy = copy(list);
  printf("Testing Copy:\n");
  printf ("List allocated at %p\n\n", listCopy->head);
  //adding new
  insertAfter(listCopy, " ", "new");
  insertAfter(listCopy, "new", " ");
  print(listCopy);
  printSeparator();

  //test search for the copy
  printf("Testing search on the copied list:\n");
  printf("Search for Hello: %d %s\n", contains(listCopy, "Hello"), (contains(listCopy, "Hello") ?  "Found!" : "Not found"));
  printf("Search for \" \": %d %s\n", contains(listCopy, " "), (contains(listCopy, " ") ?  "Found!" : "Not found"));
  printf("Search for new: %d %s\n", contains(listCopy, "new"), (contains(listCopy, "new") ?  "Found!" : "Not found"));
  printf("Search for world: %d %s\n", contains(listCopy, "world"), (contains(listCopy, "world") ?  "Found!" : "Not found"));
  //Not Found Test
  printf("Should not find Goodbye: %d %s\n", contains(listCopy, "Goodbye"), (contains(listCopy, "not found") ?  "Found!" : "Not found!"));
  printSeparator();


//test add before head
char* toAdd = "Why";
printf("Adding Why before head of list:\n");
printf ("List allocated at %p\n\n", listCopy->head);
(insertBefore(listCopy, "Hello", toAdd) ? printf("Successful add %s:\n",toAdd) : printf("Failure to add%s:\n",toAdd));
insertAfter(listCopy, toAdd, " ");
printf("\n");
print(listCopy);
printf("\n");

//test add before middle of list
toAdd = "weird";
printf("Adding weird before new:\n");
(insertBefore(listCopy, "new", toAdd) ? printf("Successful add of %s:\n",toAdd) : printf("Failure to add %s:\n",toAdd));
insertAfter(listCopy, toAdd, " ");
printf("\n");
print(listCopy);
printf("\n");

//test add to element that dosen't exist
printf("Adding before element that dosen't exist\n");
toAdd = "element";
(insertBefore(listCopy, "something", toAdd) ? printf("Successful add of %s:\n",toAdd) : printf("Failure to add %s:\n",toAdd));
printf("\n");
print(listCopy);
printf("\n");

//test add to element added by insertBefore
toAdd = "to a";
printf("Adding to an element added by insertBefore:\n");
(insertBefore(listCopy, "weird", toAdd) ? printf("Successful add of %s:\n",toAdd) : printf("Failure to add %s:\n",toAdd));
insertAfter(listCopy, toAdd, " ");
printf("\n");
print(listCopy);
printSeparator();

//test delete head
printf("Deleting Head from list:\n");
(delete(listCopy, "Why") ? printf("Successful Deletion of head\n"): printf("Failure to delete head\n"));
delete(listCopy, " ");
printf("\n");
print(listCopy);
printf("\n");

//test delete middle of list
printf("Deleting weird from middle of list:\n");
(delete(listCopy, "weird") ? printf("Successful Deletion of weird\n"): printf("Failure to delete weird\n"));
printf("\n");
print(listCopy);
printf("\n");

//test delete end of list
printf("Deleting from end of list:\n");
(delete(listCopy, "world") ? printf("Successful Deletion of world\n") : printf("failure to delete end of list\n"));
printf("\n");
print(listCopy);
printSeparator();

printf("Printing the original and copy list with visit\n");
visit(list, printNode);
visit(listCopy, printNode);
printSeparator();

printf("Printing the original and copy list with toUpperCase\n");
visit(list, toUpperCase);
print(list);
visit(listCopy, toUpperCase);
print(listCopy);
printSeparator();

//testing merge
struct LinkedList* mergeLeft = create("I");
  insertAfter(mergeLeft, "I", "am");
  insertAfter(mergeLeft, "am", "ready");

struct LinkedList* mergeRight = create(" ");
  insertAfter(mergeRight, " ", " ");
  insertAfter(mergeRight, " ", " ");

printf("Testing merge of both lists:\n");
printf("First list allocated: %p\n",mergeLeft);
print(mergeLeft);
printf("\n");

printf("Second list allocated: %p\n", mergeRight);
print(mergeRight);
printf("\n");

struct LinkedList* mergeList = merge(mergeLeft,mergeRight);
printf("New list allocated: %p\n", mergeList);
print(mergeList);
printf("\n");
printSeparator();
}