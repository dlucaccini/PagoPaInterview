class FirstExercise {

    fun getNumberOfOccurrences(array : ArrayList<String>): Int {

        val map: HashMap<Char, Boolean> = HashMap()
        var count = 0

        array.forEach { string ->
            map.clear()
            for (char in string.toCharArray()) {
                if (map[char] == true) {
                    count++
                    break
                } else {
                    map[char] = true
                }
            }

        }
        return count
    }

}
