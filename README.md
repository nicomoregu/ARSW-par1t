###Escuela Colombiana de Ingeniería
####Arquitecturas de Software
####Parcial - Tercio 1.


1. En el repositorio XXXXX se tiene una aplicación multi-hilo que busca paralelizar el procesamiento de un flujo de datos provisto por una fuente externa. En este caso, la fuente de datos es -esporádicamente- bastante lenta en la transmisión de los datos (puede pausarse incluso algunos segundos).

	En general, la funcionalidad es la siguiente:

	* El hilo DataSourceStream extrae contínuamente los datos provistos a través de la clase DataSource (importado como librería externa), y los encola en una cola concurrente.
	* Cada hilo DataStreamProcesor consulta el siguiente elemento disponible en dicha cola, lo 'procesa' (por ahora simplemente muestra su valor por STDOUT), e incrementa un contador común (usado para mostrar, posteriormente, el número de datos procesados).

	Al correr la aplicación, se puede observar que la misma usa de forma muy intensiva el procesador, dado que cuando no hay datos, realiza una ESPERA ACTIVA hasta que la cola tenga nuevamente elementos. Por otro lado, no se ha analizado si la misma presenta, en algún aspecto, condiciones de carrera que puedan llevar a comportamientos o resultados erróneos.
	
	Teniendo en cuenta lo anterior:
	
	1. Haga los ajustes necesarios para que la aplicación no use innecesariamente los recursos de CPU mientras la cola no tenga elementos. Esta solución debe igual garantizar que, en cuanto haya datos disponibles, éstos empiecen a ser procesados inmediatamente.
	2. En el archivo de respuestas indique: hay condiciones de carrera en lo planteado?. En qué clase y en qué líneas de código está la región crítica?.
	3. Haga los ajustes necesarios para que ya no se den las condiciones de carrera.
