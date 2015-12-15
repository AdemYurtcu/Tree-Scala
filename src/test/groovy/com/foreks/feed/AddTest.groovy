import spock.lang.Shared;
import spock.lang.Specification
import spock.lang.Unroll
import com.foreks.feed.MyTreeSetImpl

import org.spockframework.compiler.model.SetupBlock;

import java.lang.Class

@Unroll
class AddTest extends spock.lang.Specification {
    @Shared tree = new MyTreeSetImpl<Integer>("inorder",Comparator.naturalOrder())
    
    def "Do you have a value of #value in the tree ?"(){
        setup : 
        tree.add(10)
        tree.add(20)
        tree.add(5)
        
        when : 
         def x =tree.contains(value)
        then : 
         x==check
        where :
        
        value || check
          10  || true
          20  || true
          
    }
}
