import groovy.json.JsonSlurper
metadata {
	definition (name: "HomeSeer HS3", namespace: "fuzzysb", author: "Stuart Buchanan") {
	capability "Sensor"
    capability "Actuator"
    command "api"    
	}
    
    preferences {
		input("ip", "text", title: "IP Address", description: "Your HS3 IP Address", defaultValue: "192.168.5.213", required: true, displayDuringSetup: true)
		input("port", "text", title: "Port Number", description: "Your HS3 Port Number (Default:80)", defaultValue: "80", required: true, displayDuringSetup: true)
	}
   
	tiles (scale: 2){      
        valueTile("hubInfo", "device.hubInfo", decoration: "flat", height: 2, width: 6, inactiveLabel: false, canChangeIcon: false) {
            state "hubInfo", label:'${currentValue}'
        }
    }
	main("hubInfo")
	details(["hubInfo"])
}

def parseDescriptionAsMap(description) {
	description.split(",").inject([:]) { map, param ->
		def nameAndValue = param.split(":")
        
        if (nameAndValue.length == 2) map += [(nameAndValue[0].trim()):nameAndValue[1].trim()]
        else map += [(nameAndValue[0].trim()):""]
	}
}

def installed() {
	log.debug "Installed with settings: ${settings}"
	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"
	initialize()
}

def initialize() {
	ipSetup()
}

def api(String HS3Command, String HS3Id) {
	ipSetup()
    def cmdPath
	def hubAction
	switch (HS3Command) {
		case "on":
			cmdPath = "/"
			break;
		case "off":
			cmdPath = "/"
			break;
	}
    
	switch (HS3Command) {
		default:
			try {
				hubAction = [new physicalgraph.device.HubAction(
				method: "GET",
				path: cmdPath,
				headers: [HOST: "${settings.ip}:${settings.port}", Accept: "application/json"]
				)]
			}
			catch (Exception e) {
				log.debug "Hit Exception $e on $hubAction"
			}
			break;
	}
	return hubAction
}

def ipSetup() {
    log.debug "In IPSetup Area"
	def hosthex
	def porthex
	if (settings.ip) {
		hosthex = convertIPtoHex(settings.ip).toUpperCase()
	}
	if (settings.port) {
		porthex = convertPortToHex(settings.port).toUpperCase()
	}
	if (settings.ip && settings.port) {
        log.debug "updating Network ID to ${hosthex}:${porthex}"
		device.deviceNetworkId = "${hosthex}:${porthex}"
	}
}

private String convertIPtoHex(ip) { 
	String hexip = ip.tokenize( '.' ).collect {  String.format( '%02x', it.toInteger() ) }.join()
	return hexip
}
private String convertPortToHex(port) {
	String hexport = port.toString().format( '%04x', port.toInteger() )
	return hexport
}