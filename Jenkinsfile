import java.text.SimpleDateFormat

 

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()

 

pipeline {

    agent any
    tools {
            maven 'MAVEN'
            jdk 'Java8'
        }
    
    stages {
    
        stage ('Build') {
            steps {
                bat ("mvn clean install -DskipTests")
                bat ("mvn clean verify")
            }
        }
        
        stage ('Ejecutar Pruebas') {
            steps {
                script {
                    try {
                        
                        bat ("mvn test -Dcucumber.options=\"src/test/resources/features/ --tags \'${ESCENARIO}\' --glue sd.test.definition --plugin junit:target/cucumber/result.xml --plugin json:target/cucumber/counter.json\"")
                        bat ("mvn serenity:aggregate")
                        echo 'Ejecucion de pruebas sin errores...'
                    }
                    catch (ex) {
                        echo 'Finalizo ejecucion con fallos...'
                        error ('Failed')
                    }
                }
            }
        }
        
        stage ('Reporte') {
            steps {
                script {
                     try {
                   
                        bat ("echo ${defTimestamp}")
                        publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                      echo 'Reporte realizado con exito'
                    }
                    catch (ex) {
                        echo 'Reporte realizado con Fallos'
                        error ('Failed')
                    }
                }
            }
        
        }
        }
        post {
        always {
            publishTestResults serverAddress: 'https://seguridata.atlassian.net',
                    projectKey: 'QA',
                    filePath:'target/cucumber/*.json',
                    format: 'Cucumber',
                    autoCreateTestCases: true
					
					
			publishTestResults serverAddress: 'https://itera2020.atlassian.net',
                    projectKey: 'PC',
                    filePath:'target/cucumber/*.json',
                    format: 'Cucumber',
                    autoCreateTestCases: true		
        }
    }
    }