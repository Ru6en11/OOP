interface List<T>{
    fun add(value: T)
    fun insert(value: T, index: Int)
    fun delete(index: Int)
    fun get(index: Int): T?
    fun print()
}

class Node<T>(var value: T){
    var next: Node<T>? = null
}

class LinkedList<T>(): List<T>{
    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    override fun add(value: T) {
        var tmp = Node<T>(value)
        if(head == null){
            head = tmp
            size++
        }else{
            tail?.next = tmp
            size++
        }
        tail = tmp
    }

    override fun insert(value: T, ind: Int) {
        if (ind < 0 || ind > size) return
        var tmp = head
        var i = 0
        while(i < ind && tmp?.next != null){
            tmp = tmp.next
            i++
        }
        if(tmp?.next != null){
            var insertion = Node<T>(value)
            var tmpNext = tmp.next
            tmp.next = insertion
            insertion.next = tmpNext
            size++
        }

    }

    override fun delete(ind: Int) {
        if (size == 0) return
        var tmp = head
        var i = 0
        while(i < ind && tmp?.next != null){
            tmp = tmp.next
            i++
        }
        if(tmp?.next != null){
            tmp.next = tmp.next?.next
            size--
        }

    }

    override fun get(index: Int): T? {
        var tmp = this.head
        var i = 0
        while (tmp != null && i < index){
            tmp = tmp.next
            i++
        }
        return tmp?.value
    }
    override fun print(){
        var tmp: Node<T>? = head
        var i = 0
        while( tmp != null){
            println("index: $i , ${tmp.value}")
            tmp = tmp.next
            i++
        }
    }
}

@Suppress("UNCHECKED_CAST")
class ArrayList<T>(): List<T>{
    val size = 8
    var reserveSize = 0
    var array: Array<T?> = arrayOfNulls<Any?>(size) as Array<T?>
    override fun add(value: T) {
        if( reserveSize + 1 == size){
            var tmpArray = arrayOfNulls<Any?>(size * 2) as Array<T?>
            var i = 0
            while(i < reserveSize){
                tmpArray[i] = array[i]
                i++
            }
            array = tmpArray
            reserveSize *= 2
        }

        array[reserveSize] = value
        reserveSize++
    }

    override fun insert(value: T, ind: Int) {
        if (ind < 0 || ind > reserveSize) return
        if (reserveSize < size){
            var i = reserveSize - 1
            while (i >= ind){
                array[i + 1] = array[i]
                i--
            }
        }
        array[ind] = value
        reserveSize++
    }

    override fun delete(ind: Int) {
        if(ind > reserveSize) return
        var i = ind
        while(i < reserveSize){
            array[i] = array[i + 1]
            i++
        }
        reserveSize--
    }

    override fun get(ind: Int): T? {
        return array[ind]
    }
    override fun print(){
        var i = 0
        while(i < reserveSize){
            println("index: $i, element: ${array[i]}")
            i++
        }
    }
}