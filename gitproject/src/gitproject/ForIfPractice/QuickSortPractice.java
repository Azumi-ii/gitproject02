package gitproject.ForIfPractice;

import java.util.Random;
import java.util.Scanner;

public class QuickSortPractice {

	    public static void main(String[] args) {
	        // キーボード入力を受け取るためのScannerを作成
	        Scanner scanner = new Scanner(System.in);

	        // ユーザーに入力を促すメッセージを表示
	        System.out.print("生成する数字の個数を入力してください: ");

	        // 入力値が数値かどうかをチェック
	        if (!scanner.hasNextInt()) {
	            System.out.println("エラー: 整数を入力してください。");
	            scanner.close(); // Scannerを閉じる
	            return; // プログラムを終了
	        }

	        // 入力された個数を取得
	        int count = scanner.nextInt();

	        // 0以下の数値（0や負の数）が入力された場合のエラー処理
	        if (count <= 0) {
	            System.out.println("エラー: 1以上の正の整数を入力してください。");
	            scanner.close(); // Scannerを閉じる
	            return; // プログラムを終了
	        }

	        // 【関数化ポイント1】乱数配列作成関数を呼び出し（1〜30の範囲）
	        int[] numbers = generateRandomNumbers(count, 1, 30);

	        // 生成された元の配列を表示
	        System.out.print("生成された数字は、");
	        printArray(numbers);
	        System.out.println("です。");

	        // 【関数化ポイント2】クイックソート関数を呼び出して降順（大きい順）に並び替え
	        quickSortDescending(numbers, 0, numbers.length - 1);

	        // ソート後の配列を表示
	        System.out.print("大きい順に並べると、");
	        printArray(numbers);
	        System.out.println("です。");

	        // リソース解放
	        scanner.close();
	    }

	    /**
	     * 指定された個数と範囲のランダムな整数配列を生成する関数（メソッド）
	     * @param count 生成する個数
	     * @param min 最小値
	     * @param max 最大値
	     * @return 生成された整数の配列
	     */
	    public static int[] generateRandomNumbers(int count, int min, int max) {
	        // 指定された要素数の配列を確保
	        int[] result = new int[count];
	        // 乱数生成器の作成
	        Random random = new Random();

	        // 指定個数分だけ乱数を生成して配列に格納
	        for (int i = 0; i < count; i++) {
	            // min〜max の範囲でランダムな数値をセット
	            result[i] = random.nextInt(max - min + 1) + min;
	        }
	        // 生成した配列を返す
	        return result;
	    }

	    /**
	     * 配列をクイックソート（降順：大きい順）で並べ替える関数
	     * ※ライブラリを使わずループ（while/for）と if文 で実装
	     * 
	     * @param array ソート対象の配列
	     * @param left  ソート範囲の先頭インデックス
	     * @param right ソート範囲の末尾インデックス
	     */
	    public static void quickSortDescending(int[] array, int left, int right) {
	        // 範囲の要素が1つ以下なら処理を終了（再帰の終了条件）
	        if (left >= right) {
	            return;
	        }

	        // 中央の要素を基準値（ピボット）として設定
	        int pivot = array[(left + right) / 2];

	        // 探索用のインデックスを初期化
	        int i = left;
	        int j = right;

	        // 左右からの探索が交差するまで繰り返す
	        while (i <= j) {
	            // 降順のため、基準値より大きい要素を探す（左側から）
	            while (array[i] > pivot) {
	                i++;
	            }
	            // 降順のため、基準値より小さい要素を探す（右側から）
	            while (array[j] < pivot) {
	                j--;
	            }

	            // インデックスが交差していない場合、要素を入れ替える
	            if (i <= j) {
	                int temp = array[i]; // 一時退避
	                array[i] = array[j]; // 値の交換
	                array[j] = temp;
	                i++; // 左インデックスを進める
	                j--; // 右インデックスを戻す
	            }
	        }

	        // 基準値より左側のグループを再帰的にソート
	        if (left < j) {
	            quickSortDescending(array, left, j);
	        }
	        // 基準値より右側のグループを再帰的にソート
	        if (i < right) {
	            quickSortDescending(array, i, right);
	        }
	    }

	    /**
	     * 配列の内容を読点（、）区切りで出力する補助関数
	     * @param array 表示する配列
	     */
	    public static void printArray(int[] array) {
	        for (int i = 0; i < array.length; i++) {
	            System.out.print(array[i]);
	            if (i < array.length - 1) {
	                System.out.print("、");
	            }
	        }
	    }
	}


