## taskAffinityApp

Задание


Создать приложение, содержащее флоу регистрации. 

Пусть есть главный экран с кнопкой начала регистрации. Флоу регистрации содержит экран ввода имени, экран ввода фамилии, экран ввода возраста. 

В каждом из экранов есть кнопка Далее (открывает следующий экран), Назад (возвращает на предыдущий экран) и Закрыть (закрывает флоу регистрации)

После экрана ввода возраста закрывается флоу регистрации, открывается главный экран, на котором показывается тост “Добро пожаловать, $firstName $lastName”


Результат


![video_2024-04-18_17-06-00](https://github.com/N1oH0my/taskAffinityApp/assets/123839526/b284cdf9-51aa-4972-b5b5-ef562bb60699)



FLAG_ACTIVITY_CLEAR_TASK – таск для вызываемого Activity будет очищен, а вызываемое Activity станет в нем корневым. 

finishAffinity() завершает активности в текущем таске асинхронно.
Когда вы вызовете startActivity(intent) сразу после finishAffinity(), новая активность будет запущена в новом таске до того, как текущие активности завершатся если у телефона нет проблем с ресурсами т.е. ~всегда.