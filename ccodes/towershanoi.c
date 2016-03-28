#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct disk{
	int diameter;
	struct disk *next;
};

typedef struct{
	char tower_name;
	struct disk *n_tower;
} tower;

typedef struct{
	struct disk *tower_a;
	struct disk *tower_b;
	struct disk *tower_c;
} towers;

towers *tw;
long long tw_steps;

void towers_initialize(){
	tw_steps = 0;
	tw = malloc(sizeof(towers));
	tw->tower_a = tw->tower_b = tw->tower_c = NULL;
}

void display_disks(struct disk *tower, char tower_name){
	printf("Tower %c: ", tower_name);
	struct disk *current = tower;
	while (current != NULL){
		printf("%d ", current->diameter);
		current = current->next;
	}
	printf("\n");
}

struct disk* create_disk(int diameter){
	struct disk *new_disk = malloc(sizeof(struct disk));
	new_disk->diameter = diameter;
	new_disk->next = NULL;
	return new_disk;
}

void load_source_tower(int n_disks){
	while (n_disks > 0){
		struct disk* new_disk = create_disk(n_disks);
		--n_disks;
		new_disk->next = tw->tower_a;
		tw->tower_a = new_disk;
	}
}

void display_towers(){
	display_disks(tw->tower_a, 'A');
	display_disks(tw->tower_b, 'B');
	display_disks(tw->tower_c, 'C');
	printf("\n=================================\n");
}

void move_disk(char from, char to){
	++tw_steps;
	struct disk *new_disk;
	if (from == 'A'){
		new_disk = tw->tower_a;
		tw->tower_a = tw->tower_a->next;
	} else if (from == 'B'){
		new_disk = tw->tower_b;
		tw->tower_b = tw->tower_b->next;
	} else if (from == 'C'){
		new_disk = tw->tower_c;
		tw->tower_c = tw->tower_c->next;
	}
	
	printf("Step %lld: Disk %d moved from %c to %c\n", tw_steps, new_disk->diameter, from, to);
	
	if (to == 'A'){
		new_disk->next = tw->tower_a;
		tw->tower_a = new_disk;
	} else if (to == 'B'){
		new_disk->next = tw->tower_b;
		tw->tower_b = new_disk;
	} else if (to == 'C'){
		new_disk->next = tw->tower_c;
		tw->tower_c = new_disk;
	}
	
	display_towers();
}

void free_tower(struct disk* tower){
	struct disk *current = NULL;
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
	display_towers();	
}