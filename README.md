La diferencia entre runnable y thread es que
al extender de la clase thread 
estamos limitando la herencia de la clase a la 
que extiende ya que java no permite herencia 
multiple. Sin embargo runnable se utiliza mediante 
implementaci�n lo que no interfiere en la herencia.

Ciclo de vida de un thread:
Un hilo tiene "vida" al ser ejecutado y muere
cuando el metodo run termina su ejecuci�n, cuando
otro hilo llama a su metodo stop o el sistema operativo
decide detenerlo  

El m�todo sleep proporcionado por la clase Thread 
permite pausar la ejecuci�n del subproceso que 
se est� ejecutando actualmente durante el n�mero 
especificado en milisegundos

El m�todo join permite que un hilo espere a 
que se complete el otro.
El tiempo de espera es igual al n�mero de milisegundos 
especificado en el argumento del m�todo.
Tambi�n se puede llamar sin un argumento donde
simplemente espera hasta que el hilo muere. 

El m�todo start hace que el hilo comience a ejecutarse, 
la JVM llama al m�todo run de este hilo. El resultado 
es que dos hilos se puedan ejecutar simult�neamente.

El metodo yield es utilizado para notificarle al sistema
que el hilo actual en ejecuci�n va a dejar el cpu
por el momento, dandole lugar a otros de mayor importancia. 

