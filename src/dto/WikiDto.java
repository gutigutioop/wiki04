package dto;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * WikiDtoクラス
 * wikiデータを一つ持てるdata object(dto)
 * Java Beansの定石通り直列化用インターフェース実装
 * @author　Say Consulting Group
 * @version　1.0.0
 */
public class WikiDto implements Serializable {

  /** wikiの連番 */
  private int id;
  /** 題名 */
  private String title;
  /** 本文 */
  private String body;

  /**
   * 引数に連番とwikiファイルを指定するコンストラクタ
   * 連番とwikiが設定されたdtoインスタンスを生成する
   * @param id wikiの連番
   * @param file 読み込み対象のfile
   */
  public WikiDto(int id, File file) {
    // 連番を設定
    this.id = id;

    // wiki題名をファイルから取得してフィールドに設定
    this.title = file.getName();

    // 指定されたファイルの絶対パスを取得
    Path path = Paths.get(file.getAbsolutePath());
    
    // wiki本文をファイルから取得してフィールドに設定
    // ファイルを読み込む際、IOExceptionが発生する可能性があるためtry～catch構文を使う
    try {
      this.body = Files.readString(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * indexメソッド
   * wikiの連番と題名の文字列を返す
   * @return 【連番3桁d : 題名】左記形式に整形された文字列
   */
  public String index() {
    return String.format("【%3d : %s】", this.id, this.title);
  }

  /**
   * toStringメソッド
   * 上記indexメソッドの戻り値に、wiki本文を加えた文字列を返す
   * @return 【連番3桁d : 題名】+ 改行 + wiki本文
   */
  public String toString() {
    return String.format("%s\n%s\n", this.index(), this.body);
  }
}
