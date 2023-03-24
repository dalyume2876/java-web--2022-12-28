interface Comment {
    CommentNumber: number;
    writerEmail: string;
    boardNumber: number;
    writeDatetime: string;
    commentContent: string;
    writerProfileURL?: string | null;
    writerNickname: string;
}

export default Comment;