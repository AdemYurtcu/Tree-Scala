import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll
import com.foreks.feed.MyTreeSetImpl

@Unroll
class RemoveTest extends spock.lang.Specification {

    @Shared tree 
    def setupSpec(){
        this.tree = new MyTreeSetImpl<Integer>("inorder",Comparator.naturalOrder())
        this.tree.add(10)
        this.tree.add(20)
        this.tree.add(5)
        this.tree.add(18)
    }
    def "Do you have a value of #value in the tree ? "(){
        setup :
        
        when :
        tree.remove(value)
        def x =tree.contains(value)
        then :
        x == check
        

        where :
        value || check
        10 || false
        20 || false 
    }
}
