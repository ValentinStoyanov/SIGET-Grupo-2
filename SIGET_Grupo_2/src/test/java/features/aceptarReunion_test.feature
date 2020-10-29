
Feature: La reunion se ha aceptado correctamente

  
  Scenario Outline: El cliente llama al post de aceptar la reunion 
    Given El usuario intenta aceptar la reunion
    When El usuario acepta la llamada al post para aceptar la reunion "<temas>", "<descripcion>", "<hora_inicio>", "<hora_fin>", "<asistentes>", "<convocante>"  
  	Then El usuario recibe que la reunion ha sido aceptada "<correcto>" 

    Examples: 
      | temas | descripcion | hora_inicio | hora_fin  | asistentes | convocante  | correcto |
      | Tema1 |     Desc1   | HIni1       | HFin1     | Asist1     | Conv1       | True     |
      | Tema2 |     Desc2   | HIni2       | HFin2     | Asist2     | Conv2       | True     |
      | Tema3 |     Desc3   | HIni3       | HFin3     | Asist3     | Conv3       | True     |    
      | Tema4 |     Desc4   | HIni4       | HFin4     | Asist4     | Conv4       | False    |
      | Tema5 |     Desc5   | HIni5       | HFin5     | Asist5     | Conv5       | False 	  |
      | Tema6 |     Desc6   | HIni6       | HFin6     | Asist6     | Conv6       | False    |