#include < stdlib.h >
int nondet_uint();
#include < stdint.h >
#ifndef LENGTH
#define LENGTH 5
#endif

int main ( int argc , char * argv []) {
	unsigned int a[LENGTH];
	
	//Vorbedingungen: die Zahl in den Arrays ist zwischen 0 und 4
	
	for ( unsigned int i = 0; i < LENGTH ; i ++) {
		a[i] = nondet_uint () ;
		assume(a[i] >= 0  && a[i] < 1000) ;  //ohne upper bound wuerde es fehlschlagen
	}
	
	//ueberpruefe die Vorbedingung, dass alle Variablen kleiner als 5 sind
	for ( unsigned int i = 0; i < LENGTH ; i ++) {
		assert(a[i] >= 0);
	}
	
	//fuehre den code aus, der alle Felder um 1 erhoeht
	for (unsigned int i = 0; i < LENGTH ; i ++) {
		a[i] = a[i] + 1;
	}
	
	//Nachbedingung: Jetzt sind alle Felder mindestens 1, also groesser als 0
	for (unsigned int i = 0; i < LENGTH; i++) {
		assert(a[i] > 0) ;
	}
	return 0;
}