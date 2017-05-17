#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

void* tree(void* n1){
  int n = *(int*) n1;
  int*  param = malloc (sizeof(*param));
  if(n <= 1){
    printf("Hello, world\n");
    return NULL;
  }
  
  pthread_t left, right;
  *param = n - 1;
  pthread_create(&left, 0, tree,  param);
  pthread_join(left, NULL);
  pthread_create(&right, 0, tree,  param);
  pthread_join(right, NULL);
  
  printf("Hello, world\n");
  return NULL;
}


int main(int argc, char* argv[]){
  int volatile x = atoi(argv[1]);
  tree((void*) &x);
  return 0;
}
