FROM shoeper/glassfish:4.1.1-web

COPY dist/AUTOCARE.war /glassfish4/glassfish/domains/domain1/autodeploy/AUTOCARE.war

EXPOSE 8081

CMD ["/glassfish4/bin/asadmin", "start-domain", "--verbose", "domain1"]