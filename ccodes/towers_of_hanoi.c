#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct node{
	int key;
	struct node *next;
};

typedef struct{
	struct node *tower_a;
	struct node *tower_b;
	struct node *tower_c;
} towers;

towers *tw;
long long tw_steps;

void towers_initialize(){
	tw_steps = 0;
	tw = malloc(sizeof(towers));
	tw->tower_a = tw->tower_b = tw->tower_c = NULL;
}

	void display_disks(){
		struct node *current;
		
		printf("Tower A: ");
		current = tw->tower_a;
		while (current != NULL){
			printf("%d ", current->key);
			current = current->next;
		}
		printf("\n");
		
		printf("Tower B: ");
		current = tw->tower_b;
		while (current != NULL){
			printf("%d ", current->key);
			current = current->next;
		}
		printf("\n");
		
		printf("Tower C: ");
		current = tw->tower_c;
		while (current != NULL){
			printf("%d ", current->key);
			current = current->next;
		}
		printf("\n=================================\n");
	}

struct node* create_node(int key){
	struct node *n_node = malloc(sizeof(struct node));
	n_node->key = key;
	n_node->next = NULL;
	return n_node;
}

void move_disk(char from, char to){
	++tw_steps;
	struct node *n_node;
	if (from == 'A'){
		n_node = tw->tower_a;
		tw->tower_a = tw->tower_a->next;
	} else if (from == 'B'){
		n_node = tw->tower_b;
		tw->tower_b = tw->tower_b->next;
	} else if (from == 'C'){
		n_node = tw->tower_c;
		tw->tower_c = tw->tower_c->next;
	}
	
	printf("Step %lld: Disk %d moved from %c to %c\n", tw_steps, n_node->key, from, to);
	
	if (to == 'A'){
		n_node->next = tw->tower_a;
		tw->tower_a = n_node;
	} else if (to == 'B'){
		n_node->next = tw->tower_b;
		tw->tower_b = n_node;
	} else if (to == 'C'){
		n_node->next = tw->tower_c;
		tw->tower_c = n_node;
	}
	
	display_disks();
}
	
	void move_disks(int n_disks, char from, char inter, char to){
		if (n_disks == 1)
			move_disk(from, to);
		else{
			move_disks(n_disks - 1, from, to, inter);
			move_disk(from, to);
			move_disks(n_disks - 1, inter, from, to);
		}
	}
		
	void load_source_tower(int n_disks){
		while (n_disks > 0){
			struct node* n_node = create_node(n_disks);
			--n_disks;
			n_node->next = tw->tower_a;
			tw->tower_a = n_node;
		}
	}
	
	void free_tower(struct node* tower){
		struct node *current = NULL;
		while (tower != NULL){
			current = tower;
			tower = tower->next;
			free(current);
			current = NULL;
		}
	}
	
	int main(){
		int n = 20;
		towers_initialize();		
		load_source_tower(n);
		display_disks();	
		move_disks(n, 'A', 'B', 'C');
		free_tower(tw->tower_a);
		free_tower(tw->tower_b);
		free_tower(tw->tower_c);
		exit(0);
	}

//C:/Users/ALFRED/Documents/academics/courses/dsa/codes/ccode

 