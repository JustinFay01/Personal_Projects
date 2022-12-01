#include <stdlib.h>
#include "ArrayList.h"
#include <limits.h>
#include <stdio.h>
#include <string.h>

/*
  Retrieves the struct stored in the list at position index
  Returns a struct data object whose valid field is false if the index is outside the current bounds of the list
*/
struct data get(struct list* list, int index) {
	//Set valid to false incase condition is false
	struct data value;
	value.valid = 0;
	value.value = 0;

	//Checks if index is smaller tha ncompacity and greater than 0 
	if(index < list->capacity && index >= 0){
		//retrun the data found within the address
		return list->address[index];
	}
	else	
		return value;
}

/*
  Creates a new list capable of holding the number of entries
  specified in the parameter initialSize, marking all of the 
  entries as invalid
*/
struct list* initialize(int initialSize){

	//Allocate memory to the new list (make sure I say whats inside of maloc)
	struct list* newList = malloc(initialSize*sizeof(struct list));//don't use pointer for list 

	//Declare arraylists inital data which is its capacity and adress
	newList->capacity = initialSize; //Must Declare these two since it is a new list
	newList->address = malloc(initialSize*sizeof(struct data));

	//set all the validity indices
	for(int i =0; i < initialSize; i++){
		newList->address[i].valid = 0;
	}

	//return the new list
	return newList;
}

/*
  Sets the value stored at the given index to the requested value 
  If index is beyond the bounds of the current array, a new chunk of 
  memory is allocated, and the contents of the old array are copied 
  to the new array before setting the requested value
*/
void set(struct list* list, int index, int value){

	//If index is smaller than the lists capcity just set the index to valid and add data
	if(index < list->capacity){
		list->address[index].valid = 1;
		list->address[index].value = value;
	}
	else{
		//Allocate enough memory so index is valid
		struct data* newArray = malloc(index*2*sizeof(struct data));
		//Since we are not making new list we use data and not list

		//Copy all the exisiting elements from old array to new array
		for(int i = 0; i < list->capacity; i++){
			newArray[i] = list->address[i];
		}
		//Invalidate elements beyond original capacity
		for(int i = list->capacity; i < 2*index; i++){
			newArray[i].valid = 0;
		}
		//Set the value at index to desired value
		newArray[index].valid = 1;
		newArray[index].value = value;
		//free the memory associated with the old array 
		//Make list address point to new array 
		//change capacity
		free(list->address);
		list->address = newArray;
		list->capacity = 2*index;
	}

}

/*
  Reduces the capacity of the list pointed to by lst 
  to the given value; any data that exists with index -capacity- or 
  greater are lost
*/
void truncate(struct list* lst, int capacity){
	//Allocate memory for new array
	if(capacity < lst->capacity){
		struct data* newArray = malloc(capacity*(sizeof(struct data)));
		// Copy all exisiting elements to new array
		for(int i = 0; i <= capacity; i++){
		newArray[i] = lst->address[i];
		}
		//Free the memory associated with the old array
		free(lst->address);
		// make list address point to new array 
		lst->address = newArray;
		//Change capacity 
		lst->capacity = capacity;
	}
	else if (capacity == lst->capacity)
		;
	else{
		printf("Error: You are trying to truncate with a capcity larger than the lists orginal capacity.\n");
	}

}

/*
  Reduces the amount of memory being used by the list to match its capacity,
  by creating a new block of memory to hold exactly the right number of 
  elements, copying the elements of the existing list that have been set,
  and then freeing up the memory previously allocated to the list
*/
void compact (struct list* lst){
	//Alocate Memory into new array 
	struct data* newArray = malloc(lst->capacity*(sizeof(struct data)));
	//Copy all of the existing elements
	int i, j;
	i = j = 0;
	//if the elements are valid add them to new array
	for( ; i < lst->capacity; i++){
		if(lst->address[i].valid == 1){
			newArray[j] = lst->address[i];
			j++;
		}
	}
	//Free memory
	free(lst->address);
	//make list address point to new array
	lst->address = newArray;
	lst->capacity = j;
}
