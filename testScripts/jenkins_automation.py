import jenkins

server = jenkins.Jenkins('http://localhost:8080', username='Shubham', password='1102e100743f53189cbec02617ec0fe1b6')
user = server.get_whoami()
version = server.get_version()
print('Hello %s from Jenkins %s' % (user['fullName'], version))

server.create_job('job2', jenkins.EMPTY_CONFIG_XML)
job2=open('Checkout.py')
