package app;

import java.util.List;

import dto.WikiDto;
import model.WikiReader;

/**
 * ファイルベースWikiアプリ
 * 
 * Wikiアプリ開発04 - タイトル一覧を表示して番号でwikiを表示する準備をしよう！
 *
 * Mainクラス
 * ファイルベースWikiアプリの実行エントリポイントを持つクラス
 * @author　Say Consulting Group
 * @version　1.0.0
 */
public class Main {

  /**
   * mainメソッド
   * ファイルベースwikiアプリのエントリポイント
   * @param args コマンドライン引数(未使用)
   */
  public static void main(String[] args) {

    // ウェルカムメッセージ表示
    System.out.println("マイwikiアプリへようこそ！\n");

    // wikiのリスト読み込み
    List<WikiDto> list = WikiReader.getAll();

    // 読み込んだwikiを全て表示する
    int i = 0;
    for (WikiDto item : list) {
      System.out.print(item.index());
      if (i % 4 == 3) {
        // 一定数のタイトル表示後は改行する
        System.out.println("\n");
      } else {
        // 改行しない場合は半角スペースを2つ表示
       System.out.print("  ");
      }
      i++;
    }
  }
}
