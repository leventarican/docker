#!/bin/bash

echo starting payara server foreground mode verbose on...

exec bin/asadmin start-domain --verbose
