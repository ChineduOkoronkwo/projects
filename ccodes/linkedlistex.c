#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct node{
	int key;
	struct node *next;
};

struct node *first = NULL;

int is_empty(){
	return (first == NULL);
}

void insert_node(int key){
	struct node *current = malloc(sizeof(struct node));
	current->key = key;
	current->next = first;
	first = current;
}

void remove_first(){
	if (is_empty() == 0){
		struct node *current = first;
		first = current->next;
	}
}

void remove_node(int key){
	struct node *previous  = NULL;
	struct node *current = first;
	while (current != NULL && current->key != key){
		previous = current;
		current = current->next;
	}
	
	if (current != NULL){
		if (previous == NULL)
			first = current->next;
		else
			previous->next = current->next;
	}		
}

void display_list(){
	struct node *current = first;
	while (current != NULL){
		printf("%d ", current->key);
		current = current->next;
	}
	printf("\n");
}

int main(){
	insert_node(1);
	insert_node(2);
	insert_node(3);
	insert_node(4);
	insert_node(5);	
	insert_node(6);
	insert_node(7);
	insert_node(8);
	insert_node(9);
	insert_node(10);
	display_list();
	
	remove_first();
	remove_first();
	display_list();
	
	remove_node(4);
	display_list();
	
	remove_node(6);
	display_list();
	
	remove_node(4);
	display_list();
	
	exit(0);
}
