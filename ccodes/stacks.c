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

towers * towers_initialize(){
	towers *tw = malloc(sizeof(towers));
	tw->tower_a = tw->tower_b = tw->tower_c = NULL;
}

 