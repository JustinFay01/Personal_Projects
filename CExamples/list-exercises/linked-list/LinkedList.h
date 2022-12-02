struct Node {
  struct Node* next;
  char* data;
};

struct LinkedList {
  struct Node* head;
};

struct LinkedList* create(char* data);
struct LinkedList* insertAfter(struct LinkedList* list, char* valueToFind, char* newValue);

//Print function for lists
void print(struct LinkedList* list);

/* 
Returns 1 if the list named "list" contains a node whose value is sValue, 0 if not
*/
int contains(struct LinkedList* list, char* sValue);

/*
Make a copy of the list
*/
struct LinkedList* copy(struct LinkedList* src);

/**
 * Inserts a new node with value "value" into the list referenced by "list" 
 * so that the new node comes before the node with value "sValue"
 * 
 * Returns 0 no node with the value sValue can be found in the list. 
 * Returns -1 if the new node is created
 * 
 */
int insertBefore (struct LinkedList* list, char* sValue, char* value);

/**
 * Deletes the nodes in the list with value "value"
 * returns 0 if such a node cannot be found; otherwise
 * returns 1
 * 
 */
int delete(struct LinkedList* list, char* value);

/**
 * Visits each node of the list, calling the function
 * pointed to by "visitFunc" for each node. 
 * 
 */
void visit(struct LinkedList* list, void (*visitFunc) (struct Node* value));

/**
 * Print a single node.
 */
void printNode(struct Node* value);

/**
 * Turn one nodes string to uppercase
 * 
 */
void toUpperCase(struct Node* value);

/**
 * @brief Merge two seperate linked lists together so that each 
 * node alternates from left list to right list 
 * 
 * @return pointer to new linked list containg all elemets
 */
struct LinkedList* merge(struct LinkedList* left, struct LinkedList* right);
