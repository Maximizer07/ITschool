public class ExampleActivity extends Activity {
    // Вызывается при создании активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Инициализирует активность.
    }
    // Вызывается после завершения метода onCreate
// Используется для восстановления состояния UI
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
    // Вызывается, когда активность стала видимой
    @Override
    protected void onStart() {
        super.onStart();
// Проделать необходимые действия для активности, видимой на экране
    }
    // Должен вызываться в начале видимого состояния.
// На самом деле Android вызывает данный обработчик только
// для активностей, восстановленных из неактивного состояния
    @Override
    protected void onResume() {
        super.onResume();
// Восстановить приостановленные обновления UI,
// потоки и процессы, приостановленные, когда
// активность была в неактивном состоянии
    }
    // Вызывается перед выходом из активного состояния,
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
    // Вызывается перед выходом из активного состояния
    @Override
    protected void onPause() {
        super.onPause();
// Приостановить обновления UI, потоки или трудоемкие процессы,
// ненужные, когда активность не на переднем плане
    }
    // Вызывается перед выходом из видимого состояния
    @Override
    protected void onStop() {
        super.onStop();
// Приостановить обновления UI, потоки ненужные, когда активность не на переднем плане.
// Сохранить все данные и изменения в UI.
    }
    // Вызывается перед уничтожением активности
    @Override
    protected void onDestroy() {
        super.onDestroy();
// Освободить все ресурсы, включая работающие потоки, соединения с БД.
    }
}