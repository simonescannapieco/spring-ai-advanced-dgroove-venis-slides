    ...
    
    private String getContentType(Resource multimediaFile) {
        String contentType = URLConnection.guessContentTypeFromName(multimediaFile.getFilename());

        if (contentType == null || contentType.equals("application/octet-stream")) {
            String fileName = multimediaFile.getFilename();
            if (fileName != null) {
                String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
                contentType = switch (extension) {
                    case "mp3" -> "audio/mpeg";
                    case "wav" -> "audio/wav";
                    case "m4a" -> "audio/mp4";
                    case "ogg" -> "audio/ogg";
                    case "flac" -> "audio/flac";
                    default -> "media/unknown";
                };
            } else {
                contentType = "media/unknown";
            }
        }

        return contentType;
    }
    
}
