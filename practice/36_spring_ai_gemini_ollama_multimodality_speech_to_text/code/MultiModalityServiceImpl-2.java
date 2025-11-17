    ...
    
    private String getContentType(Resource audioFile) {
        String contentType = URLConnection.guessContentTypeFromName(audioFile.getFilename());
        
        if (contentType == null || contentType.equals("application/octet-stream")) {
            String fileName = audioFile.getFilename();
            if (fileName != null) {
                String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
                contentType = switch (extension) {
                    case "mp3" -> "audio/mpeg";
                    case "wav" -> "audio/wav";
                    case "m4a" -> "audio/mp4";
                    case "ogg" -> "audio/ogg";
                    case "flac" -> "audio/flac";
                    default -> "audio/mpeg";
                };
            } else {
                contentType = "audio/mpeg";
            }
        }
        
        return contentType;
    }
    
}
