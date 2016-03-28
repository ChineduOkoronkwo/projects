#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct node{
	int key;
	struct node *next;
};

struct queue{
	struct node *head;
	struct node *tail;
};

struct queue * queue_initialize(void){
	struct queue *q = malloc(sizeof(struct queue));
	assert(q);
	q->head = q->tail = NULL;
	return q;
}

int is_empty(struct queue *q){
	return (q->head == NULL);
}

void enq(struct queue *q, int key){
	struct node *new_node = malloc(sizeof(struct node));
	assert(new_node);
	new_node->key = key;
	new_node->next = NULL;
	
	if (q->head == NULL)
		q->head = new_node;
	else
		q->tail->next = new_node;
	q->tail = new_node;
}

int deq(struct queue *q){
	assert(!is_empty(q));
	struct node *ret_node = q->head;
	int key = ret_node->key;
	q->head = ret_node->next;
	free(ret_node);
	return key;
}

void display_queue(struct queue *q){
	struct node *current = q->head;
	while (current != NULL){
		printf("%d ", current->key);
		current = current->next;
	}
	printf("\n");
}

int main(){
	struct queue *q = queue_initialize();
	int i;
	for (i = 1; i < 11; ++i)
		enq(q, i);
	display_queue(q);
	int key = deq(q);	
	printf("Deleted %d from the queue\n", key);
	display_queue(q);
	key = deq(q);	
	printf("Deleted %d from the queue\n", key);
	display_queue(q);
	
	exit(0);
}

