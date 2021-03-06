#!/bin/bash
#
# Deploy a jar, source jar, and javadoc jar to Sonatype's snapshot repo.
#
# Adapted from https://coderwall.com/p/9b_lfq and
# http://benlimmer.com/2013/12/26/automatically-publish-javadoc-to-gh-pages-with-travis-ci/

set -e

./gradlew publish -PmavenCentralUsername="${SONATYPE_USERNAME}" -PmavenCentralPassword="${SONATYPE_PASSWORD}"
