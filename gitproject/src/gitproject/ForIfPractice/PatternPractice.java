package gitproject.ForIfPractice;

import java.util.Scanner;

/**
 * 課題1〜3：図形表示プログラム
 */
public class PatternPractice {

    public static void main(String[] args) {
        // キーボード入力を受け取るためのScannerオブジェクトを作成
        Scanner scanner = new Scanner(System.in);

        // ユーザーへサイズの入力を促すメッセージを表示
        System.out.print("サイズを入力してください: ");

        // 入力された文字列が数値であるかチェック
        if (!scanner.hasNextInt()) {
            // 数値以外が入力された場合のエラー処理
            System.out.println("エラー: 整数を入力してください。");
            scanner.close(); // Scannerを閉じる
            return; // プログラムを終了
        }

        // 入力された数値を取得
        int size = scanner.nextInt();

        // 0以下の数値（0や負の数）が入力された場合のエラー分岐処理
        if (size <= 0) {
            System.out.println("エラー: 1以上の正の整数を入力してください。");
            scanner.close(); // Scannerを閉じる
            return; // プログラムを終了
        }

        System.out.println("\n--- 課題1 ---");
        // 課題1の三角形表示メソッドを呼び出す
        printTriangleTask1(size);

        System.out.println("\n--- 課題2 ---");
        // 課題2の逆三角形表示メソッドを呼び出す
        printTriangleTask2(size);

        System.out.println("\n--- 課題3 ---");
        // 課題3の逆ピラミッド表示メソッドを呼び出す
        printTriangleTask3(size);

        // リソースを解放するためにScannerを閉じる
        scanner.close();
    }

    /**
     * 課題1: 直角三角形を表示するメソッド
     * @param size 三角形のサイズ
     */
    public static void printTriangleTask1(int size) {
        // 行数分の繰り返し（1行目からsize行目まで）
        for (int i = 1; i <= size; i++) {
            // 各行の文字数分の繰り返し（i個の'$'を出力）
            for (int j = 1; j <= i; j++) {
                // 文字'$'を表示（改行なし）
                System.out.print("$");
            }
            // 1行分の出力が終わったら改行
            System.out.println();
        }
    }

    /**
     * 課題2: 右詰めの逆直角三角形を表示するメソッド
     * @param size 三角形のサイズ
     */
    public static void printTriangleTask2(int size) {
        // 行数分の繰り返し（0行目からsize-1行目まで）
        for (int i = 0; i < size; i++) {
            // 全角スペースを出力して位置を揃える（i個出力）
            for (int j = 0; j < i; j++) {
                System.out.print("　"); 
            }
            // 星（全角＊）を出力するループ（size - i 個出力）
            for (int k = 0; k < size - i; k++) {
                System.out.print("＊"); 
            }
            // 1行分の出力が終わったら改行
            System.out.println();
        }
    }

    /**
     * 課題3: 逆ピラミッド（二等辺三角形）を表示するメソッド
     * @param size 三角形のサイズ
     */
    public static void printTriangleTask3(int size) {
        // 行数分の繰り返し（0行目からsize-1行目まで）
        for (int i = 0; i < size; i++) {
            // 先頭の全角スペースを出力するループ（i個出力）
            for (int j = 0; j < i; j++) {
            	System.out.print("　"); 
            }
            // 星（全角＊）を出力するループ（(size - i) * 2 - 1 個出力）
            for (int k = 0; k < (size - i) * 2 - 1; k++) {
                System.out.print("＊");
            }
            // 1行分の出力が終わったら改行
            System.out.println();
        }
    }
}