class ServerNameGenerator {

  public static String randomStringFrom(String[] list){
    int select = (int)Math.floor(Math.random() * list.length);
    return list[select];
  }

  public static void main(String[] args){

    String[] adjectives = {
      "vaudevillian", "vicarious", "valourous", "venal", "virulent",
      "vicious", "voracious", "vigilant", "virtuous", "verbose"
    };

    String[] nouns = {
      "view", "veteran", "victim", "villian", "fate",
      "visage", "vox populi", "vermin", "vice", "volition"
    };

    String serverName = randomStringFrom(adjectives) + " "
      + randomStringFrom(nouns);

    System.out.println(serverName);
  }

}
