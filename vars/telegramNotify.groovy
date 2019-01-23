def notify(JENKINSJOB, PKG, SERVER, STATUS="SUCCESS") {
   BOT_TOKEN="744656308:AAE50sZTFOokn7f1hLTg5JiX2VBUQr14drA"
   MESSAGE = """*JenkinsJob: $JENKINSJOB*
   ```
   DeployedPkg:		$PKG$
   OnServer:  		$SERVER$
   Status:			$STATUS
   ```"""
   JSON = '{"chat_id": "@adm_notify", "disable_notification": false, "text": "' + "${MESSAGE}" + '"}'
   def proc = ["curl", "-X", "POST", "-H", "Content-Type: application/json", "-d", "${JSON}",  "https://api.telegram.org/bot${BOT_TOKEN}/sendMessage"].execute()
   Thread.start { System.err << proc.err }
   proc.waitFor()
}

