# Задача

## Условие

Артём слышал, что список фамилий в публикациях сортируют в лексикографическом порядке. Артём очень тщеславен, и пытается
придумать, в каком порядке должны идти буквы в алфавите, чтобы его фамилия в публикации стояла первой. Помогите Артёму
написать программу которая бы вычисляла такой алфавит, в котором заданный список фамилий был бы лексикографически
отсортированным или определяла, что это невозможно.

### Вход

Подается в стандартный ввод. В первой строке записано целое число n (1 ≤ n ≤ 100), количество имен.

В каждой из следующих n строк записано по одному слову name%i , обозначающему i-е имя. Каждое имя содержит только
строчные буквы латинского алфавита, не более 100 символов. Все имена различны.

### Выход

Подается в стандартный вывод. Если существует такой порядок букв, при котором имена в данном списке следуют в
лексикографическом порядке, выведите любой такой порядок в виде перестановки символов 'a'–'z' (иными словами, выведите
сначала первую букву модифицированного алфавита, затем вторую, и так далее).

## Решение

Построил граф который задаёт отношение частичного порядка для букв алфавита. Т.е. `graph[i][j] == true`, если `i-тая`
буква должна идти по алфавиту раньше `j-той`. Потом проверяю, если а графе есть путь от буквы `x` до `y` и путь от `y`
до `x` это значит что **не существует** такой перестановки букв в алфавите чтобы данный набор фамилий был отсортирован (
его быть не может так как получается что буква `x` должна быть **до**, а так же **после** `y`, что **невозможно**). Если
такое не наблюдается, то по массиву, в котором для `i-ого` индекса (он же обозначает `i-тую` букву) указано сколько букв
больше него, я строю ответ.