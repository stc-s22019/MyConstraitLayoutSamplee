package jp.suntech.s22019.myconstraitlayoutsamplee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirmButton = findViewById(R.id.button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });

        // 送信ボタンのクリックリスナーを設定
        Button sendButton = findViewById(R.id.button2);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDialog();
            }
        });

        // クリアボタンのクリックリスナーを設定
        Button clearButton = findViewById(R.id.button3);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("送信内容をご確認ください\n以下の内容でよろしいですか?");

        // 入力内容を取得
        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etMail);
        EditText etComment = findViewById(R.id.etComment);
        EditText etEmailTitle = findViewById(R.id.etEmailTitle);

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String comment = etComment.getText().toString();
        String emailTitle = etEmailTitle.getText().toString();

        // ダイアログのメッセージに入力内容を追加
        String message = "名前: " + name + "\nメールアドレス: " + email + "\nメールのタイトル: " + emailTitle + "\n質問内容: " + comment;
        builder.setMessage(message);

        builder.setPositiveButton("戻る", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }

    private void sendDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("送信確認\n以下の内容でよろしいですか?");

        // 入力内容を取得
        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etMail);
        EditText etComment = findViewById(R.id.etComment);
        EditText etEmailTitle = findViewById(R.id.etEmailTitle);

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String comment = etComment.getText().toString();
        String emailTitle = etEmailTitle.getText().toString();

        // ダイアログのメッセージに入力内容を追加
        String message = "名前: " + name + "\nメールアドレス: " + email + "\nメールのタイトル: " + emailTitle + "\n質問内容: " + comment;
        builder.setMessage(message);

        builder.setPositiveButton("はい", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("送信しました");
            }
        });

        builder.setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("送信を取り消しました");
            }
        });
        builder.show();
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void clearFields() {
        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etMail);
        EditText etComment = findViewById(R.id.etComment);
        EditText etEmailTitle = findViewById(R.id.etEmailTitle);

        // すべてのEditTextのテキストをクリア（空欄に設定）する
        etName.setText("");
        etEmail.setText("");
        etComment.setText("");
        etEmailTitle.setText("");
    }
}
