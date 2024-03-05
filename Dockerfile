FROM quay.io/wildfly/wildfly
COPY target/jakartaee-hello-world.war /opt/jboss/wildfly/standalone/deployments/
