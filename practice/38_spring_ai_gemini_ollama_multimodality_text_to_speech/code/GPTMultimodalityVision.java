@Autowired
OpenAiChatModel chatModel;

ClassPathResource imageResource = new ClassPathResource("/multimodal.test.png");

UserMessage userMessage = new UserMessage("Descrivi il contenuto dell'immagine: ",
        new Media(MimeTypeUtils.IMAGE_PNG, this.imageResource));

ChatResponse response = this.chatModel.call(new Prompt(this.userMessage,
        OpenAiChatOptions.builder().model(OpenAiApi.ChatModel.GPT_4_O.getValue()).build()));