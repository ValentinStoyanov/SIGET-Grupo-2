Feature: Se convoca una reunion correctamente
  Scenario Outline: Convocar una reunion
    Given el usuario intenta crear una reunion
    When el cliente hace la llamada POST/llena el formulario con los parametros de una reunion: temas "<temas>" descripcion "<descripcion>" hora_inicio "<hora_inicio>" hora_fin "<hora_fin>" asistentes "<asistentes>" convocante "<convocante>" 
    Then el cliente recibe respuesta de que la reunion es guardada en la base de datos, todo queda guardado "<guardado>" 



   Examples: 
     | temas  | descripcion 	| hora_inicio | hora_fin | asistentes | convocantes | guardado |
     | tema1 	| descripcion1 	| h_i1				|	h_f1		 |  asis1			| 	conv1			| true  |
     | tema2 	| descripcion2 	| F_i2   			|	h_f2		 |	asis2			| 	conv2			| true |
     | tema3 	| descripcion3 	| h_i3				|	h_f3		 |  asis3			| 	conv3			| false  |
     | tema4 	| descripcion4 	| h_i4				|	h_f4		 |  asis4			| 	conv4 		| false  |
