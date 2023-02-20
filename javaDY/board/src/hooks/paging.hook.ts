import { useEffect, useState } from "react";
import { IPreviewItem } from "src/interfaces";
import { BOARD_LIST } from "src/mock";

const usePagingHook = () => {
    const COUNT = 5;
    
    const [boardList, setBoardList] = useState<IPreviewItem[]>([])
    const [viewList, setViewList] = useState<IPreviewItem[]>([]);
    const [pageNumber, setPageNumber] = useState<number>(1);

    //? 한 페이지에 5개의 게시물을 보여주고자 할 때
    //? 배열의 시작 인덱스 5 * pageNumber - 5 -> 5 * (pageNumber - 1)
    //? 배열의 마지막 인덱스 5 * pageNumber - 1

    const onPageHandler = (page: number) => {
        setPageNumber(page);
        const tmpList: IPreviewItem[] = [];
        const startIndex = COUNT  * (page - 1);
        const endIndex = COUNT * page - 1;
        
        //? s -> 35, e -> 39
        for (let index = startIndex; index <= endIndex; index++){
            if (boardList.length < index + 1) break;
            tmpList.push(boardList[index]);
        }      
        setViewList(tmpList);
    }


    // useEffect(() => {
    //     const tmp = !content ? BOARD_LIST : BOARD_LIST.filter((board) => board.boardTitle.includes(content as string));
    //     setBoardList(tmp);
    // }, [content])

    useEffect(() => {
        onPageHandler(pageNumber);
    }, [boardList])

    return {boardList, viewList, pageNumber, onPageHandler, COUNT, setBoardList};
}

export default usePagingHook;