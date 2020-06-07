#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int lock = 0;
int shared = 0;

void *incrementer(void *args) {
    int i;
    for (i = 0; i < 100; i++) {
        while (lock > 0);
        lock = 1;
        shared++;
        lock = 0;
    }
    return NULL;
}

int main(int argc, char *argv[]) {
    pthread_t *threads;
    int n, i;
    if (argc < 2) {
        fprintf(stderr, "ERROR: Invalid number of threads\n");
        exit(1);
    }
    if ((n = atol(argv[1])) == 0) {
        fprintf(stderr, "ERROR: Invalid number of threads\n");
        exit(1);
    }
    threads = calloc(n, sizeof(pthread_t));
    for (i = 0; i < n; i++) {
        pthread_create(&threads[i], NULL, incrementer, NULL);
    }
    for (i = 0; i < n; i++) {
        pthread_join(threads[i], NULL);
    }
    printf("Shared: %d\n", shared);
    printf("Expect: %d\n", n * 100);
    return 0;
}
