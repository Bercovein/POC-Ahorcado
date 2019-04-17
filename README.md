La diferencia entre runnable y thread es que
al extender de la clase thread 
estamos limitando la herencia de la clase a la 
que extiende ya que java no permite herencia 
multiple. Sin embargo runnable se utiliza mediante 
implementación lo que no interfiere en la herencia.

Ciclo de vida de un thread:
Un hilo tiene "vida" al ser ejecutado y muere
cuando el metodo run termina su ejecución, cuando
otro hilo llama a su metodo stop o el sistema operativo
decide detenerlo  

El método sleep proporcionado por la clase Thread 
permite pausar la ejecución del subproceso que 
se está ejecutando actualmente durante el número 
especificado en milisegundos

El método join permite que un hilo espere a 
que se complete el otro.
El tiempo de espera es igual al número de milisegundos 
especificado en el argumento del método.
También se puede llamar sin un argumento donde
simplemente espera hasta que el hilo muere. 

El método start hace que el hilo comience a ejecutarse, 
la JVM llama al método run de este hilo. El resultado 
es que dos hilos se puedan ejecutar simultáneamente.

El metodo yield es utilizado para notificarle al sistema
que el hilo actual en ejecución va a dejar el cpu
por el momento, dandole lugar a otros de mayor importancia. 

