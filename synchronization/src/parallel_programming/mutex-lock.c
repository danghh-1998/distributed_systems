#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define INIT_BALANCE 50
#define NUM_TRANS 100
int balance = INIT_BALANCE;
int credits = 0;
int debits = 0;
pthread_mutex_t mutex;

void *transactions(void *args) {
    int i, v;
    pthread_mutex_lock(&mutex);
    for (i = 0; i < NUM_TRANS; i++) {
        srand(time(NULL));
        v = rand() % NUM_TRANS;
        if (rand() % 2) {
            balance = balance + v;
            credits = credits + v;
        } else {
            balance = balance - v;
            debits = debits + v;
        }
    }
    pthread_mutex_unlock(&mutex);
    return 0;
}


int main(int argc, char *argv[]) {
    int n_threads, i;
    pthread_t *threads;
    if (argc < 2) {
        fprintf(stderr, "ERROR: Require number of threads\n");
        exit(1);
    }
    n_threads = atol(argv[1]);
    if (n_threads <= 0) {
        fprintf(stderr, "ERROR: Invalid value for number of threads\n");
        exit(1);
    }
    if (pthread_mutex_init(&mutex, NULL) != 0) {
        printf("\n mutex init has failed\n");
        return 1;
    }
    threads = calloc(n_threads, sizeof(pthread_t));
    for (i = 0; i < n_threads; i++) {
        pthread_create(&threads[i], NULL, transactions, NULL);
    }
    for (i = 0; i < n_threads; i++) {
        pthread_join(threads[i], NULL);
    }
    printf("\tCredits:\t%d\n", credits);
    printf("\t Debits:\t%d\n\n", debits);
    printf("%d+%d-%d=\t % d\n", INIT_BALANCE, credits, debits, INIT_BALANCE + credits - debits);
    printf("\t Balance:\t%d\n", balance);
    free(threads);
    pthread_mutex_destroy(&mutex);
    return 0;
}