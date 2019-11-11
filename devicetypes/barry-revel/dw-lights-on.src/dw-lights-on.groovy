/**
 *  DW Lights On
 *
 *  Copyright 2018 Barry Revel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition (name: "DW Lights On", namespace: "Barry Revel", author: "Barry Revel") {
		capability "Switch"
		capability "Timed Session"
	}


	simulator {
		// TODO: define status and reply messages here
	}

	tiles {
		// TODO: define your main and details tiles here
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
	// TODO: handle 'switch' attribute
	// TODO: handle 'sessionStatus' attribute
	// TODO: handle 'completionTime' attribute

}

// handle commands
def on() {
	log.debug "Executing 'on'"
	// TODO: handle 'on' command
}

def off() {
	log.debug "Executing 'off'"
	// TODO: handle 'off' command
}

def start() {
	log.debug "Executing 'start'"
	// TODO: handle 'start' command
}

def stop() {
	log.debug "Executing 'stop'"
	// TODO: handle 'stop' command
}

def pause() {
	log.debug "Executing 'pause'"
	// TODO: handle 'pause' command
}

def cancel() {
	log.debug "Executing 'cancel'"
	// TODO: handle 'cancel' command
}

def setCompletionTime() {
	log.debug "Executing 'setCompletionTime'"
	// TODO: handle 'setCompletionTime' command
}