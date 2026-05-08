import java.util.*;

class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList<>();

        int[] indegree = new int[numCourses];

        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++)
            if(indegree[i] == 0)
                q.offer(i);

        int count = 0;

        while(!q.isEmpty()){

            int node = q.poll();
            count++;

            for(int nei : graph[node]){

                indegree[nei]--;

                if(indegree[nei] == 0)
                    q.offer(nei);
            }
        }

        return count == numCourses;
    }
}