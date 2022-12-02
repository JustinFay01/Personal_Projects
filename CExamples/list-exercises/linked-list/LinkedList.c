#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <ctype.h>
#include "LinkedList.h"

struct Node *createNode(char *data)
{
  //allocate memory for the new node
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  //  Make sure memory was successfully allocated for the new node
  if (node == NULL)
  {
    return NULL;
  }
  //initalize nodes startring variables
  node->next = NULL;
  //strdup data so you can mutate strings later
  node->data = strdup(data);
  return node;
}

struct LinkedList *create(char *data)
{
  //allocate memory for new linked list
  struct LinkedList *newList = (struct LinkedList *)malloc(sizeof(struct LinkedList));
  if (newList != NULL)
  {
    //if memory has been succesfully aloated create a node to store as the linkedlists head
    newList->head = createNode(data);
  }
  return newList;
}

struct LinkedList *insertAfter(struct LinkedList *list, char *insertNodeValue, char *newValue)
{
  //Make copy of current node to iterate with
  struct Node *currentNode = list->head;
  //While the current node is not null compre the data to the node value looking fo 
  while (currentNode != NULL && strcmp(currentNode->data, insertNodeValue) != 0)
  {
    currentNode = currentNode->next;
  }

  //  If we didn't find the value, return NULL to indicate that fact
  if (currentNode == NULL)
  {
    return NULL;
  }

  //  Otherwise, create a new node, and set up the pointers appropriately
  struct Node *newNode = createNode(newValue);
  if (newNode != NULL)
  {
    newNode->next = currentNode->next;
    currentNode->next = newNode;
  }
  return list;
}

/*
Print out the values within the list
*/
void print(struct LinkedList *list)
{
  struct Node *tmp = list->head;
  while (tmp != NULL)
  {
    printf("%s", tmp->data);
    tmp = tmp->next;
  }
}

/*
Returns 1 if the list named "list" contains a node whose value is sValue, 0 if not
*/
int contains(struct LinkedList *list, char *sValue)
{
  // create temp node to iterate with
  struct Node *tmp = list->head;
  while (tmp != NULL)
  {
    //if found return one otherwise keep going till end of list
    if (!strcmp(tmp->data, sValue))
      return 1;
    else
      tmp = tmp->next;
  }
  return 0;
}

/*
Make a copy of the list
*/
struct LinkedList *copy(struct LinkedList *src)
{
  // create a new list with data from old head
  struct LinkedList *copy = create(src->head->data);
  struct Node *srcH = src->head;
  struct Node *cH = copy->head;
  // for each node in src create a new node point previous node to it
  // Increment src node
  srcH = srcH->next;
  while (srcH != NULL)
  {
    //create the next node, insert new element after, increment
    struct Node *nextNode = createNode(srcH->data);
    insertAfter(copy, cH->data, nextNode->data);
    cH = cH->next;
    srcH = srcH->next;
  }
  return copy;
}

/**
 * Inserts a new node with value "value" into the list referenced by "list"
 * so that the new node comes before the node with value "sValue"
 *
 * Returns 0 no node with the value sValue can be found in the list.
 * Returns -1 if the new node is created
 *
 */
int insertBefore(struct LinkedList *list, char *sValue, char *value)
{
  // Check if the value is either the head node
  // If it is before head node
  // Make new node point its next value to head
  // Change value of head

  struct Node *tmp = list->head;
  if (!strcmp(tmp->data, sValue) && !strcmp(tmp->data, list->head->data))
  {
    struct Node *newNode = createNode(value);
    newNode->next = list->head;
    list->head = newNode;
    return -1;
  }
  // if it is not the head
  // create new node
  // set new nodes next value to the current nodes next value
  // chang ecurrent nodes next value to new node
  while (tmp->next != NULL)
  {
    if (!strcmp(tmp->next->data, sValue))
    {
      struct Node *newNode = createNode(value);
      newNode->next = tmp->next;
      tmp->next = newNode;
      return -1;
    }
    tmp = tmp->next;
  }
  return 0;
}

/**
 * Deletes the nodes in the list with value "value"
 * returns 0 if such a node cannot be found; otherwise
 * returns 1
 *
 */
int delete (struct LinkedList *list, char *value)
{
  struct Node* tmp = list->head;
  // If it is head node
  // Set list head to next value
  if (!strcmp(tmp->data, value))
  {
    list->head = tmp->next;
    free(tmp);
    return 1;
  }
  // if it is in the middle of the list
  // set tmp->next = tmp->next->next

  // if it is the end of the list
  // tmp->next = null;
  while (tmp->next != NULL)
  {
    if (!strcmp(tmp->next->data, value))
    {
      if (tmp->next->next != NULL)
      {
        struct Node* toFree = tmp->next;
        tmp->next = tmp->next->next;  
        free(toFree);
        return 1;
      }
      free(tmp->next->next);
      return 1;
    } 
    tmp = tmp->next;
  }

  return 0;
}

/**
 * Visits each node of the list, calling the function
 * pointed to by "visitFunc" for each node. 
 * 
 */
void visit(struct LinkedList* list, void (*visitFunc) (struct Node* value)){
  //functional programming method 
  //create copy of lists head to iterate with
  //call the function passed in paramters on each node
  //then increment 
    struct Node* tmp = list->head;
    while (tmp != NULL)
    {
      visitFunc(tmp);
      tmp = tmp->next;
    }
}

/**
 * Print a single node
 * 
 */
void printNode(struct Node* value){
   printf("%s", value->data);
}

/**
 * Turn one nodes string to uppercase
 * 
 */
void toUpperCase(struct Node* value){
  char* string = value->data;
  for(int i = 0; value->data[i] != '\0';i++){
    if(string[i] >= 'a' && string[i] <= 'z')
      string[i] = string[i] - 32;
  }
} 

/**
 * @brief Merge two seperate linked lists together so that each 
 * node alternates from left list to right list 
 * 
 * @return pointer to new linked list containg all elemets
 */
struct LinkedList* merge(struct LinkedList* left, struct LinkedList* right){

  //create tmp copies
  struct Node* leftTmp = left->head;
  struct Node* rightTmp = right->head;

 while(rightTmp->next != NULL){
    //create copy of right list
     struct Node* tmp = createNode(rightTmp->data);

    //set copy to lefts next value
     tmp->next = leftTmp->next;
    //set left->next to right list value
     leftTmp->next = tmp;
   
    //incerment both
     rightTmp = rightTmp->next;
     leftTmp = leftTmp->next->next;
  }
  free(right->head);
  free(right);
  return left;
}