package oit.is.z2354.kaizi.janken.model;

public class User {
  int id;
  String name;

  // Thymeleafでフィールドを扱うためにはgetter/setterが必ず必要
  // vscodeのソースコード右クリック->ソースアクションでsetter/getterを簡単に追加できる
  public String getUserName() {
    return name;
  }

  public void setUserName(String userName) {
    this.name = userName;
  }

  public String getChamberName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
