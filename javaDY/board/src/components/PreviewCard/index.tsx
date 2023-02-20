import React from 'react'

import { Card, Box, Avatar, Typography } from '@mui/material'
import { IPreviewItem } from 'src/interfaces'
import BoardListItem from '../BoardListItem'
import CardActionArea from '@mui/material/CardActionArea'
import { useNavigate } from 'react-router-dom'

interface Props  {
    previewItem: IPreviewItem
}

export default function PreviewCard({ previewItem }: Props) {

    const backgroundImage = `url(${previewItem.img})`
    const navigator = useNavigate();

  return (
    <Card >
      <CardActionArea sx={{ height: '508px', backgroundImage: backgroundImage, backgroundSize: 'cover', display: 'flex', flexDirection: 'column-reverse'}} onClick={() => navigator(`/board/detail/${previewItem.boardNumber}`)}>
        <Box sx={{height: '100%', display: 'flex', flexDirection: 'column-reverse'}}>
            <Box sx={{p: '24px'}}>
            <Box sx={{ display: 'flex' }}>
              {/* 1 */}
              <Box sx={{mr: '8px'}}>
                <Avatar alt="Remy Sharp" src="" />
              </Box>
              {/* 2 */}
              <Box>
                <Typography sx={{fontSize: '12px', fontWeight: 500, color: '#ffffff'}}>{previewItem.writeNickname}</Typography>
                <Typography sx={{mt: '2px', fontSize: '12px', fontWeight: 400, color: 'rgba(255, 255, 255, 0.7)'}}>2023. 02. 15.</Typography>
              </Box>
            </Box>
            
            <Box  sx={{mt: '16px', mb: '16px'}}>
              <Typography sx={{ fontSize: '16px', fontWeight: 500, color: '#ffffff'}}>{previewItem.boardTitle}</Typography>
              <Typography sx={{mt: '5px', fontSize: '12px', fontWeight: 400, color: 'rgba(255, 255, 255, 0.7)'}}>Content</Typography>
            </Box>
            
            <Box>
              <Typography sx={{ fontSize: '12px', fontWeight: 400, color: 'rgba(255, 255, 255, 0.7)'}}>{`댓글 ${previewItem.commentCount} · 좋아요 ${previewItem.likeCount} · 조회수 ${previewItem.viewCount}`}</Typography>
            </Box>
          </Box>
        </Box>
        
        </CardActionArea>
    </Card>
  )
}
