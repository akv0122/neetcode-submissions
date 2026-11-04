class Tweet {
    int tweetId;
    int tweetTime;

    public Tweet(int tweetId, int tweetTime) {
        this.tweetId = tweetId;
        this.tweetTime = tweetTime;
    }
}

class User {
    int userId;
    List<Tweet> tweets; // use linkedList for insertion at the head to get the latest 10 tweets.
    HashSet<Integer> followers; // to store followers

    public User(int userId) {
        this.userId = userId;
        followers = new HashSet<>();
        followers.add(userId);//adding self as a follower
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet t) {
        tweets.addFirst(t);
    }

    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }

    public void removeFollower(int followeeId) {
        followers.remove(followeeId);
    }
}

class Twitter {
    HashMap<Integer, User> userMap; // in order to map userId with user object
    int timeCounter;

    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timeCounter++;

        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }

        User user = userMap.get(userId);
        user.addTweet(new Tweet(tweetId, timeCounter));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(
                userId)) { // if the user is not present we can return an empty arrayList.
            return new ArrayList<>();
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.tweetTime - a.tweetTime);

        // add self Tweets + follwers tweets to the pq
        User user = userMap.get(userId);

        for (int followerId : user.followers) {
            int count = 0;
            for (Tweet tweet : userMap.get(followerId).tweets) {
                pq.offer(tweet);
                count++;

                if (count > 10)
                    break;
            }
        }

        List<Integer> result = new ArrayList<>(); 
        int index = 0; 

        while(!pq.isEmpty() && index < 10){
            Tweet tweet = pq.poll(); 
            result.add(tweet.tweetId); 
            index++; 
        }   

        return result; 

     }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }

        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }

        User user = userMap.get(followerId);
        user.addFollower(followeeId);
        
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return;
        }

        User user = userMap.get(followerId);
        user.removeFollower(followeeId);
    }
}
