// pipeline {
//     agent any
//
//     environment {
//         SERVER_IP = "your_server_ip"
//         SERVER_USER = "ubuntu"
//         APP_NAME = "springboot-app"
//     }
//
//     stages {
//
//         stage('Checkout Code') {
//             steps {
//                 git 'https://github.com/yourusername/yourrepo.git'
//             }
//         }
//
//         stage('Build with Maven') {
//             steps {
//                 sh 'mvn clean package -DskipTests'
//             }
//         }
//
//         stage('Deploy to Server') {
//             steps {
//                 sh '''
//                 scp target/*.jar $SERVER_USER@$SERVER_IP:/home/$SERVER_USER/$APP_NAME.jar
//                 ssh $SERVER_USER@$SERVER_IP "
//                     pkill -f $APP_NAME || true
//                     nohup java -jar /home/$SERVER_USER/$APP_NAME.jar > app.log 2>&1 &
//                 "
//                 '''
//             }
//         }
//     }
// }