curl "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash-preview-tts:generateContent" \
  -H "x-goog-api-key: $GEMINI_API_KEY" -X POST -H "Content-Type: application/json" \
  -d '{
  "contents": [{
    "parts":[{
      "text": "Mario: Come va oggi Maria? Maria: Abbastanza bene, te?"
    }]
  }],
  "generationConfig": {
    "responseModalities": ["AUDIO"],
    "speechConfig": {
      "multiSpeakerVoiceConfig": {
        "speakerVoiceConfigs": [{
            "speaker": "Joe",
            "voiceConfig": {
              "prebuiltVoiceConfig": {
                "voiceName": "Kore"
              }
            }
          }, {
            "speaker": "Jane",
            "voiceConfig": {
              "prebuiltVoiceConfig": {
                "voiceName": "Puck"
              }
            }
          }]
      }
    }
  },
  "model": "gemini-2.5-flash-preview-tts",
}' | jq -r '.candidates[0].content.parts[0].inlineData.data' | base64 --decode > out.pcm

ffmpeg -f s16le -ar 24000 -ac 1 -i out.pcm out.wav